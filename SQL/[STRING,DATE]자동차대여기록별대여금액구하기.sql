SELECT HISTORY_ID, 
    (CASE
     WHEN DAYS >= 90
     THEN ROUND(DAYS*DAILY_FEE
                *(100-(SELECT DISCOUNT_RATE 
                       FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                       WHERE DURATION_TYPE='90일 이상' AND CAR_TYPE = '트럭'))
                /100
            ,0)
     WHEN DAYS >= 30
     THEN ROUND(DAYS*DAILY_FEE
                *(100-(SELECT DISCOUNT_RATE 
                       FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                       WHERE DURATION_TYPE='30일 이상' AND CAR_TYPE = '트럭'))
                /100
            ,0)
     WHEN DAYS >= 7
     THEN ROUND(DAYS*DAILY_FEE
                *(100-(SELECT DISCOUNT_RATE
                       FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                       WHERE DURATION_TYPE='7일 이상' AND CAR_TYPE = '트럭'))
                /100
            ,0)
     ELSE DAILY_FEE * DAYS
    END) AS FEE
FROM (SELECT H.HISTORY_ID, DATEDIFF(H.END_DATE, H.START_DATE)+1 AS DAYS, C.DAILY_FEE
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
        JOIN CAR_RENTAL_COMPANY_CAR C
        USING(CAR_ID)
        WHERE C.CAR_TYPE = '트럭'
     ) AS SUB
ORDER BY FEE DESC, HISTORY_ID DESC
