package by.training.finalproject.service.util;

import by.training.finalproject.entity.*;
import by.training.finalproject.dao.*;
import by.training.finalproject.dao.DAOexception.DAOException;
import by.training.finalproject.service.serviceException.ServiceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BuildEntityUtility {
    private BuildEntityUtility() {}

    public static void buildProduct(List<Product> products, Transaction transaction) throws ServiceException {
        try {
            UserDao userDao = (UserDao) transaction.createDao(UserDao.class.getName());
            Map<Integer, User> users = new HashMap<>();
            User user;
            Integer userID;

            for (Product product : products) {
                user = product.getUser();
                if (user != null) {     // if user set in product
                    userID = user.getId();
                    user = users.get(userID);
                    if (user == null) {     // if there is no user in map
                        user = userDao.read(userID);
                        users.put(userID, user);
                    }
                    product.setUser(user);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static void buildPurchase(List<Purchase> purchases, Transaction transaction) throws ServiceException {
        try {
            UserDao userDao = (UserDao) transaction.createDao(UserDao.class.getName());
            LocalAddressDao localAddressDao = (LocalAddressDao) transaction.createDao(LocalAddressDao.class.getName());
            Map<Integer, User> users = new HashMap<>();
            Map<Integer, LocalAddress> localAddresses = new HashMap<>();
            User user;
            LocalAddress localAddress;
            Integer id;

            for (Purchase purchase : purchases) {
                user = purchase.getUser();
                if (user != null) {     // if user set in purchase
                    id = user.getId();
                    user = users.get(id);
                    if (user == null) {     // if there is no user in map
                        user = userDao.read(id);
                        users.put(id, user);
                    }
                    purchase.setUser(user);
                }
                localAddress = purchase.getLocalAddress();
                if (localAddress != null) {
                    id = localAddress.getId();
                    localAddress = localAddresses.get(id);
                    if (localAddress == null) {
                        localAddress = localAddressDao.read(id);
                        localAddresses.put(id, localAddress);
                    }
                    purchase.setLocalAddress(localAddress);
                }
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public static void buildProductList(List<ProductList> listOfProductList, Transaction transaction) throws ServiceException {
        try {
            PurchaseDao purchaseDao = (PurchaseDao) transaction.createDao(PurchaseDao.class.getName());
            ProductDao productDao = (ProductDao) transaction.createDao(ProductDao.class.getName());
            Map<Integer, Purchase> purchases = new HashMap<>();
            Map<Integer, Product> products = new HashMap<>();
            Purchase purchase;
            Product product;
            Integer id;

            for (ProductList productList : listOfProductList) {
                purchase = productList.getPurchase();
                if (purchase != null) {
                    id = purchase.getId();
                    purchase = purchases.get(id);
                    if (purchase == null) {
                        purchase = purchaseDao.read(id);
                        purchases.put(id, purchase);
                    }
                    productList.setPurchase(purchase);
                }
                product = productList.getProduct();
                if (product != null) {
                    id = product.getId();
                    product = products.get(id);
                    if (product == null) {
                        product = productDao.read(id);
                        products.put(id, product);
                    }
                    productList.setProduct(product);
                }
            }

            buildPurchase(new ArrayList<>(purchases.values()), transaction);
            buildProduct(new ArrayList<>(products.values()), transaction);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
