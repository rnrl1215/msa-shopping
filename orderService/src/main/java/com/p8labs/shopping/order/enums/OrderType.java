package com.p8labs.shopping.order.enums;

public enum OrderType {
    IN_PROGRESS,    // 주문 진행 중 (결제 대기 등)
    PAYMENT_DONE,   // 결제 완료 (배송 요청 전)
    SHIPPING,       // 배송 중 (추가됨)
    SHIPPING_DONE,  // 배송 완료 (추가됨)
    DONE,           // 최종 구매 확정 (모든 프로세스 종료)
    CANCEL          // 주문 취소
}