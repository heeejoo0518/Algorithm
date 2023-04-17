SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE='세단')
    AND SUBSTR(START_DATE,1,7) = '2022-10'
ORDER BY CAR_ID DESC
