# Session based Shopping Cart
A session based shopping cart built using JSP and Servlets, which closely follows MVC archtitecture without using any third-
party frameworks like Spring MVC.

==> Displays products fetched from a database and stores it in application scope to avoid reload each and every time web-
    app is loaded and making it future-proof, in case new products are to be added.    

==> Uses MySQL to as a database.

==> Connection Pool is achieved using open source Hikari CP.

==> Orders and Ordered-products are mapped onto each other so that an admin can have a single decluttered list of orders
    and can find out products from corrosponding order id.
