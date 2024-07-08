package com.testepic.DTO;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal total, Long senderId, Long receiverId) {
}
