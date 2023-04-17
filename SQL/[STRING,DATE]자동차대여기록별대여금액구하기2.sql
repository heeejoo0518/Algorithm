SELECT H.HISTORY_ID, 
    (CASE
     WHEN (DATEDIFF(H.END_DATE, H.START_DATE)+1) >= 90 
        THEN ROUND((DATEDIFF(H.END_DATE, H.START_DATE)+1)
                   *C.DAILY_FEE
                   *(100-(SELECT DISCOUNT_RATE
                         FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                         WHERE DURATION_TYPE='90일 이상' AND CAR_TYPE = '트럭'))
                    /100
            ,0)
     WHEN (DATEDIFF(H.END_DATE, H.START_DATE)+1) >= 30 
        THEN ROUND((DATEDIFF(H.END_DATE, H.START_DATE)+1)
                   *C.DAILY_FEE
                   *(100-(SELECT DISCOUNT_RATE
                          FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                          WHERE DURATION_TYPE='30일 이상' AND CAR_TYPE = '트럭'))
                    /100
            ,0)
     WHEN (DATEDIFF(H.END_DATE, H.START_DATE)+1) >= 7 
        THEN ROUND((DATEDIFF(H.END_DATE, H.START_DATE)+1)
                   *C.DAILY_FEE
                   *(100-(SELECT DISCOUNT_RATE
                          FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                          WHERE DURATION_TYPE='7일 이상' AND CAR_TYPE = '트럭'))
                    /100
            ,0)
     ELSE (DATEDIFF(H.END_DATE, H.START_DATE)+1)*C.DAILY_FEE
    END) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
USING(CAR_ID)
WHERE C.CAR_TYPE = '트럭'
ORDER BY FEE DESC, H.HISTORY_ID DESC
