package edu.act.moneytransfer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Lombok;

@Builder
@Data
public class TransferRequest {
    private Long senderId;
    private Long receiverId;
    private Double amount;
    private String reason;
    
}
