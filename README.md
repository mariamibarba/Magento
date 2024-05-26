# Magento
# Magento E-commerce Project

## Description

This project is a Magento-based e-commerce application. It provides a platform for users to browse, search, and purchase products online. Users can create accounts, manage their wishlists, and add items to their shopping carts. This README file outlines the test cases used to verify the functionality of the application.

## Features

- User Registration and Authentication
- Product Search and Filtering
- Wishlist Management
- Shopping Cart Management
- Product Sorting

## Test Cases

### 1. Create an Account with a Random Email

**Objective**: Verify that a user can create an account with a randomly generated email, log in, and log out successfully.

**Steps**:
1. Navigate to the account creation page.
2. Enter a random email address and other required details.
3. Submit the registration form.
4. Check that the account is created and the user is logged in.
5. Log out of the account.

**Expected Result**: The account should be created successfully, and the user should be able to log in and log out without issues.

### 2. Create an Account with an Already Used Email

**Objective**: Verify that a user cannot create an account with an email address that is already in use.

**Steps**:
1. Navigate to the account creation page.
2. Enter an email address that is already registered.
3. Submit the registration form.

**Expected Result**: The system should display an error message indicating that the email address is already in use.

### 3. Search Products, Filter by Price, Add to Wishlist (Logged In)

**Objective**: Verify that a logged-in user can search for products, filter the results by price, add the first product to the wishlist, and check the wishlist.

**Steps**:
1. Log in to the account.
2. Use the search bar to search for products.
3. Apply a price filter to the search results.
4. Select the first product from the filtered results.
5. Add the product to the wishlist.
6. Check the wishlist to confirm the product was added.

**Expected Result**: The product should be successfully added to the wishlist, and it should be visible in the wishlist.

### 4. Search Products, Filter by Price, Add to Wishlist (Not Logged In)

**Objective**: Verify that a user must be logged in to add items to the wishlist.

**Steps**:
1. Use the search bar to search for products.
2. Apply a price filter to the search results.
3. Select the first product from the filtered results.
4. Attempt to add the product to the wishlist.

**Expected Result**: The system should prompt the user to log in or register before adding items to the wishlist.

### 5. Navigate to Tops, Sort by Price, Add to Cart (All Fields Checked)

**Objective**: Verify that a user can sort products by price, select the first item, check all fields, add the item to the cart, and confirm that it was added successfully.

**Steps**:
1. Navigate to the "Tops" category.
2. Sort the products by price.
3. Select the first item in the sorted list.
4. Check all fields (e.g., size, color).
5. Click the "Add to Cart" button.
6. Confirm that the product was added to the cart successfully.

**Expected Result**: The product should be added to the cart without any issues.

### 6. Navigate to Tops, Sort by Price, Add to Cart (Quantity Not Checked)

**Objective**: Verify that a user cannot add an item to the cart if the quantity field is not checked.

**Steps**:
1. Navigate to the "Tops" category.
2. Sort the products by price.
3. Select the first item in the sorted list.
4. Check all fields except the quantity.
5. Click the "Add to Cart" button.

**Expected Result**: The system should prevent the product from being added to the cart and display an error message indicating that the quantity must be specified.


## Setup

To set up the project locally, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/your-magento-project.git
