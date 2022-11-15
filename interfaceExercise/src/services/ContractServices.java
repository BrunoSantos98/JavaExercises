package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractServices {

    private OnlinePaymentService onlinePaymentService;

    public ContractServices(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract c, Integer months){
        Double basicQuota = c.getTotalValue()/months;

        for(int i = 1; i <= months; i++){
            LocalDate dueDate = c.getDate().plusMonths(i);
            Double interest =onlinePaymentService.interest(basicQuota,i);
            Double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            c.getInstallments().add(new Installment(dueDate,quota));
        }
    }
}
