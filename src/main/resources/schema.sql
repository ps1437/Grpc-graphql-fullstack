-- Drop tables if they exist
DROP TABLE IF EXISTS Reviews;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Products;

-- Table to store information about products
CREATE TABLE IF NOT EXISTS Products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    brand VARCHAR(100),
    category VARCHAR(100),
    image_url VARCHAR(255),
    stock_quantity INT,
    is_available BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Table to store information about users
CREATE TABLE IF NOT EXISTS Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,  -- Store password hashes, not plain text
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table to store reviews
CREATE TABLE IF NOT EXISTS Reviews (
    review_id BINARY(16) PRIMARY KEY,
    product_id INT,
    user_id INT,
    rating INT NOT NULL,
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES Products(product_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Insert sample data into Users table
INSERT INTO Users (first_name, last_name, username, email, password)
VALUES
    ('John', 'Doe', 'john_doe', 'john@example.com', 'hashed_password_1'),
    ('Jane', 'Smith', 'jane_smith', 'jane@example.com', 'hashed_password_2'),
    ('Bob', 'Johnson', 'bob_johnson', 'bob@example.com', 'hashed_password_3');

-- Insert sample data into Products table
INSERT INTO Products (name, description, price, brand, category, image_url, stock_quantity, is_available)
VALUES
    ('Laptop', 'High-performance laptop with SSD', 999.99, 'TechCorp', 'Electronics', 'laptop_image.jpg', 50, true),
    ('Smartphone', '4G smartphone with dual camera', 399.99, 'MobileTech', 'Electronics', 'phone_image.jpg', 100, true),
    ('Running Shoes', 'Comfortable running shoes for athletes', 79.99, 'FootFit', 'Apparel', 'shoes_image.jpg', 200, true),
    ('Coffee Maker', 'Programmable coffee maker with grinder', 129.99, 'BrewMaster', 'Appliances', 'coffee_maker_image.jpg', 30, true),
    ('Backpack', 'Durable backpack with multiple compartments', 49.99, 'OutdoorGear', 'Accessories', 'backpack_image.jpg', 150, true);

-- Insert sample data into Reviews table
INSERT INTO Reviews (review_id, product_id, user_id, rating, comment)
VALUES
    (RANDOM_UUID(), 1, 1, 4, 'Great product! Highly recommended.'),
    (RANDOM_UUID(), 1, 2, 5, 'Excellent quality and fast shipping.'),
    (RANDOM_UUID(), 2, 3, 3, 'Not bad, but could be improved.'),
    (RANDOM_UUID(), 3, 1, 5, 'Fantastic! Will buy again.');