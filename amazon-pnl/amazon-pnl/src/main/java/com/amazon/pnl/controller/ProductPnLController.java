package com.amazon.pnl.controller;

import com.amazon.pnl.model.MonthlyProfitRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/pnl")
public class ProductPnLController {
    @PostMapping("/monthly-net-profit")
    public double calculateNetProfit(@RequestBody MonthlyProfitRequest request) {
        double gstPercent = 18.0;
        double amazonFeeUSD = 39.99;
//        double dollarRate = request.getDollarRate()>0?request.getDollarRate() : 86.0;
        double dollarRate = request.getDollarRate();
        double gstAmount = request.getManagementFee() * (gstPercent / 100);
        double totalManagementFee = request.getManagementFee() + gstAmount;
        double amazonMonthlyFee = amazonFeeUSD * dollarRate;

        double finalProfit = request.getOrderProfit()
                - totalManagementFee
                - amazonMonthlyFee
                - request.getStorageFee()
                - request.getAdFee();

        return finalProfit;
    }

}
