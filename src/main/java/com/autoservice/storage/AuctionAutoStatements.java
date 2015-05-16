package com.autoservice.storage;

import Auction.AuctionAuto$;
import Auction.Bid$;
import Auction.ListAuctionAutos;
import Auction.ListAuctionAutos$;
import com.autoservice.storage.mapping.AvailableAutoEntity;
import com.google.common.base.Preconditions;
import com.netflix.astyanax.connectionpool.OperationResult;
import com.netflix.astyanax.connectionpool.exceptions.ConnectionException;
import com.netflix.astyanax.model.ColumnFamily;
import com.netflix.astyanax.model.CqlResult;
import com.netflix.astyanax.model.Row;
import com.netflix.astyanax.query.PreparedCqlQuery;
import com.netflix.astyanax.serializers.ByteSerializer;
import com.netflix.astyanax.serializers.MapSerializer;
import com.netflix.astyanax.serializers.StringSerializer;
import org.apache.cassandra.db.marshal.UTF8Type;

import java.util.HashMap;
import java.util.Map;


public class AuctionAutoStatements extends TableStorage {

    private static class Holder {
        static final AuctionAutoStatements INSTANCE = new AuctionAutoStatements();
    }

    public static final AuctionAutoStatements getInstance() {
        return Holder.INSTANCE;
    }

    private ColumnFamily CF = ColumnFamily.newColumnFamily("auction", StringSerializer.get(),
            StringSerializer.get());

    private ColumnFamily<String, String> CF_AUCTION =
            new ColumnFamily<String, String>("auction",
                    StringSerializer.get(),
                    StringSerializer.get(),
                    ByteSerializer.get()

            );



    private static final String SELECT_ALL = "SELECT * FROM auction";


    private PreparedCqlQuery<String, String> SELECT_AUTO_ALL_PREPARED
            = keyspace
            .prepareQuery(CF)
            .withCql(SELECT_ALL)
            .asPreparedStatement();




    public ListAuctionAutos readAll() throws ConnectionException {

        ListAuctionAutos listAutos = ListAuctionAutos$.MODULE$.apply();

        try {
            OperationResult<CqlResult<String, String>> result
                    = keyspace.prepareQuery(CF)
                    .withCql(SELECT_ALL)
                    .execute();
            String carBrand, model, lot, price, status, exactCloseDate, details, sorted, id = null, author = null, creationTime = null, bidprice = null;

            for (Row<String, String> row : result.getResult().getRows()) {

                Map<String, String> bids = row.getColumns().getValue("bids",
                        new MapSerializer<String, String>(UTF8Type.instance, UTF8Type.instance)
                        , new HashMap<String, String>());
                carBrand = row.getColumns().getColumnByName("carbrand").getStringValue();
                model = row.getColumns().getColumnByName("model").getStringValue();
                lot = row.getColumns().getColumnByName("lot").getStringValue();
                price = row.getColumns().getColumnByName("price").getStringValue();
                status = row.getColumns().getColumnByName("status").getStringValue();
                exactCloseDate = row.getColumns().getColumnByName("exactclosedate").getStringValue();
                details = row.getColumns().getColumnByName("details").getStringValue();
                sorted = row.getColumns().getColumnByName("sorted").getStringValue();
                for (Map.Entry<String, String> entry : bids.entrySet()) {

                    if (entry.getKey().equals("id"))
                        id = entry.getValue();
                    else if (entry.getKey().equals("author"))
                        author = entry.getValue();
                    else if (entry.getKey().equals("creationtime"))
                        creationTime = entry.getValue();
                    else if (entry.getKey().equals("bidprice"))
                        bidprice = entry.getValue();

                }

                Auction.Bid bid = Bid$.MODULE$.apply(id, author, creationTime, bidprice);
                Auction.AuctionAuto auctionAuto = AuctionAuto$.MODULE$.apply(carBrand, model, lot, price, status, exactCloseDate, details, bid, sorted);
                listAutos.addAuto(auctionAuto);

            }

        } catch (ConnectionException e) {
        }
        return listAutos;
    }


}