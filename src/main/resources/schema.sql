-- Drop the table if it exists
DROP TABLE IF EXISTS Movies;

-- Table to store information about movies
CREATE TABLE IF NOT EXISTS Movies (
    Movie_ID INT PRIMARY KEY,
     Rating INT,
     Release_Year Int,
    Title VARCHAR(255) NOT NULL,
    Genre VARCHAR(50),
    Director VARCHAR(100),
    Description TEXT
);

DROP TABLE IF EXISTS Products;

CREATE TABLE Products (
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


INSERT INTO Movies (Movie_ID, Rating, Release_Year, Title, Genre, Director, Description)
VALUES
    (1, 8, 2010, 'Inception', 'Sci-Fi', 'Christopher Nolan', 'A mind-bending thriller about dreams and reality.'),
    (2, 9, 1994, 'The Shawshank Redemption', 'Drama', 'Frank Darabont', 'Two imprisoned men bond over several years, finding solace and eventual redemption through acts of common decency.'),
    (3, 9, 1972, 'The Godfather', 'Crime', 'Francis Ford Coppola', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'),
    (4, 9, 1994, 'Pulp Fiction', 'Crime', 'Quentin Tarantino', 'Interwoven stories of Los Angeles mobsters, fringe players, small-time criminals, and a mysterious briefcase.'),
    (5, 8, 1994, 'Forrest Gump', 'Drama', 'Robert Zemeckis', 'A man with a low IQ, who achieved much in his life despite his limitations.'),
    (6, 9, 2008, 'The Dark Knight', 'Action', 'Christopher Nolan', 'Batman sets out to dismantle the remaining criminal organizations that plague Gotham City.');


INSERT INTO Products (name, description, price, brand, category, image_url, stock_quantity, is_available)
VALUES
  ('Laptop', 'High-performance laptop with SSD', 999.99, 'TechCorp', 'Electronics', 'laptop_image.jpg', 50, true),
  ('Smartphone', '4G smartphone with dual camera', 399.99, 'MobileTech', 'Electronics', 'phone_image.jpg', 100, true),
  ('Running Shoes', 'Comfortable running shoes for athletes', 79.99, 'FootFit', 'Apparel', 'shoes_image.jpg', 200, true),
  ('Coffee Maker', 'Programmable coffee maker with grinder', 129.99, 'BrewMaster', 'Appliances', 'coffee_maker_image.jpg', 30, true),
  ('Backpack', 'Durable backpack with multiple compartments', 49.99, 'OutdoorGear', 'Accessories', 'backpack_image.jpg', 150, true);
