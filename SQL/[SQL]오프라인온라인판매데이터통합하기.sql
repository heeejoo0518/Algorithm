SELECT *
FROM (
    SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
    FROM ONLINE_SALE
    UNION ALL
    SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT
    FROM OFFLINE_SALE
) AS SUB
WHERE DATE_FORMAT(SUB.SALES_DATE,'%Y-%m') = '2022-03'
ORDER BY SUB.SALES_DATE, SUB.PRODUCT_ID, SUB.USER_ID
;