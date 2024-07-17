INSERT INTO public.wish_lists (created_at,created_by,updated_at,updated_by,customer_id,product_id) VALUES
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,1,1),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,1,2);
	 
	 
	 
INSERT INTO public.users (created_at,created_by,updated_at,updated_by,address,full_name,mail,mobile_number,user_type_id) VALUES
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'456 Avenue','Jane Smith','jane@example.com','0987654321',1),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'123 Street','John Doe','john@example.com','1234567890',1);
	 
	 
	 INSERT INTO public.users (created_at,created_by,updated_at,updated_by,address,full_name,mail,mobile_number,user_type_id) VALUES
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'456 Avenue','Jane Smith','jane@example.com','0987654321',1),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'123 Street','John Doe','john@example.com','1234567890',1);
	 
	 INSERT INTO public.products (created_at,created_by,updated_at,updated_by,code,description,"name",amount) VALUES
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P001','Product 1 Description','Product 1',10.0),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P002','Product 2 Description','Product 2',20.0),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P003','Product 2 Description','Product 3',20.0),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P004','Product 2 Description','Product 4',20.0),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P005','Product 2 Description','Product 5',20.0),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P007','Product 2 Description','Product 7',20.0),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P008','Product 2 Description','Product 8',20.0),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'P006','Product 2 Description','Product 6',20.0);
	 
	 INSERT INTO public.payment_types (created_at,created_by,updated_at,updated_by,"name") VALUES
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'Credit Card'),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,'BKASH');
	 
	 INSERT INTO public.orders (created_at,created_by,updated_at,updated_by,payment_type_id,user_id,total_amount,order_date,order_no) VALUES
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,1,1,500.0,'2024-06-01 10:00:00','V001'),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,2,2,600.0,'2024-01-03 10:00:00','V002');
	 
	 INSERT INTO public.order_details (created_at,created_by,updated_at,updated_by,product_id,quantity,total_amount,amount,order_id) VALUES
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,5,1,20.0,20.0,2),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,1,5,50.0,10.0,1),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,2,6,60.0,10.0,1),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,4,10,100.0,10.0,1),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,6,11,220.0,20.0,2),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,7,4,40.0,20.0,2),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,8,7,140.0,20.0,2),
	 ('2023-01-01 10:00:00',1,'2023-01-01 10:00:00',1,6,2,20.0,10.0,1);
