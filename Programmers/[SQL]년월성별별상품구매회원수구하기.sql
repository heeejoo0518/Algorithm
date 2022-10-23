SELECT YEAR(SALES_DATE) AS YEAR, MONTH(SALES_DATE) MONTH, GENDER, COUNT(DISTINCT SALE.USER_ID) AS USERS
FROM USER_INFO INFO
INNER JOIN ONLINE_SALE SALE
ON INFO.USER_ID = SALE.USER_ID
WHERE GENDER IS NOT NULL
GROUP BY 1,2,3
ORDER BY 1,2,3
;