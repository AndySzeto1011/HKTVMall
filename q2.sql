CREATE TABLE order_tote_process_log (
    id BIGINT(20) PRIMARY KEY,  
    tote_number VARCHAR(20) NOT NULL,  
    action_code VARCHAR(255) NOT NULL,  
    process_date DATETIME NOT NULL,  
    user_code VARCHAR(255) NOT NULL  
);

INSERT INTO order_tote_process_log (tote_number, action_code, process_date, user_code) VALUES
(123789,'START','2023-11-01 09:16:50','SYS'),
(199888,'START','2023-11-01 09:16:55','SYS'),
(124554,'START','2023-11-01 09:17:03','SYS'),
(123789,'PICKED','2023-11-01 09:17:03','SYS'),
(123789,'PACKED','2023-11-01 10:35:50','P1'),
(124554,'PICKED','2023-11-01 11:00:50','SYS'),
(124554,'PACKED','2023-11-01 11:03:50','P2');

SELECT user_code, tote_number, COUNT(*) AS packed_totes
FROM order_tote_process_log 
WHERE action_code = 'PACKED'
AND process_date >= '2023-11-01 10:00:00'
AND process_date <= '2023-11-01 10:59:59'
GROUP BY user_code, tote_number;