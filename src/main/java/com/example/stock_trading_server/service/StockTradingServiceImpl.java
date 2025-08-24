package com.example.stock_trading_server.service;

import com.example.stock_trading_server.entity.Stock;
import com.example.stock_trading_server.repository.repository.StockRepository;
import com.rajat.grpc.StockRequest;
import com.rajat.grpc.StockResponse;
import com.rajat.grpc.StockTradingServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class StockTradingServiceImpl extends StockTradingServiceGrpc.StockTradingServiceImplBase {

    private final StockRepository stockRepository;
    public StockTradingServiceImpl(StockRepository stockRepository)
    {
        this.stockRepository=stockRepository;
    }

    @Override
    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {
        //super.getStockPrice(request, responseObserver);

        //stockName -> DB -> map response -> return

        String stockSymbol=request.getStockSymbol();
        Stock stockEntity=stockRepository.findByStockSymbol(stockSymbol);

        StockResponse stockResponse=StockResponse.newBuilder()
                .setStockSymbol(stockEntity.getStockSymbol())
                .setPrice((stockEntity.getPrice()))
                .setTimestamp(stockEntity.getLastUpdated().toString())
                .build();

        responseObserver.onNext(stockResponse);
        responseObserver.onCompleted();
    }
}
