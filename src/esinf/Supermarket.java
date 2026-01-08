/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author DEI-ISEP
 */
public class Supermarket {
    Map<Invoice, Set<Product>> sup;

    Supermarket() {
        sup = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List<String> l) throws Exception {

        for (int i = 0; i < l.size(); i++) {
            String[] str = l.get(i).split(",");

            if (str[0].equalsIgnoreCase("i")) {

                String reference = str[1];
                String date = str[2];

                Invoice invoice = new Invoice(reference, date);

                Set<Product> productSet = new HashSet<>();
                for (int j = i + 1; j < l.size(); j++) {

                    String[] p = l.get(j).split(",");

                    if (p[0].equalsIgnoreCase("p")) {
                        String identification = p[1];
                        int qtd = Integer.parseInt(p[2]);
                        long price = Long.parseLong(p[3]);

                        Product product = new Product(identification, qtd, price);

                        productSet.add(product);

                    } else {
                        break;
                    }

                }
                sup.put(invoice, productSet);
            }

        }
    }

    // returns a set in which each number is the number of products in the r
    // invoice
    Map<Invoice, Integer> numberOfProductsPerInvoice() {

        Map<Invoice, Integer> numberProducts = new HashMap<>();

        for (Invoice invoice : sup.keySet()) {
            Set<Product> productSet = sup.get(invoice);
            int numberOfProducts = productSet.size();

            numberProducts.put(invoice, numberOfProducts);

        }

        return numberProducts;

    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> invoiceSet = new HashSet<>();

        for (Invoice invoice : sup.keySet()) {
            if (invoice.getDate().isAfter(d1) && invoice.getDate().isBefore(d2)) {
                invoiceSet.add(invoice);
            }
        }

        return invoiceSet;
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {

        long total = 0;

        for (Set<Product> p : sup.values()) {
            for (Product product : p) {
                if (product.getIdentification().equals(productId)) {
                    total += product.getPrice() * product.getQuantity();
                }
            }

        }

        return total;
    }

    // converts a map of invoices and troducts to a map which key is a product
    // identification and the values are a set of the invoices in which it appears
    Map<String, Set<Invoice>> convertInvoices() {

//        Map<String, Set<Invoice>> stringSetMap = new HashMap<>();
//
//        for (Set<Product> products : sup.values()) {
//            for (Product p : products) {
//                if (!stringSetMap.containsKey(p.getIdentification())) {
//                    stringSetMap.put(p.getIdentification(), new HashSet<>());
//                }
//            }
//        }
//
//        for(Map.Entry<String, Set<Invoice>> str: stringSetMap.entrySet()){
//
//            for(Map.Entry<Invoice, Set<Product>> entries: sup.entrySet()){
//                Invoice inv = entries.getKey();
//                Set<Product> productSet = entries.getValue();
//
//                for(Product p: productSet){
//                    if(p.getIdentification().equals(str.getKey()) && !str.getValue().contains(inv)){
//                        str.getValue().add(inv);
//                    }
//                }
//
//            }
//
//        }
//
//
//        return stringSetMap;

        Map<String, Set<Invoice>> result = new HashMap<>();

        for (Invoice invoice : sup.keySet()) {

            Set<Product> products = sup.get(invoice);

            for (Product product : products) {

                String identification = product.getIdentification();

                Set<Invoice> invoicesForProduct = result.get(identification);

                if (invoicesForProduct == null) {
                    invoicesForProduct = new HashSet<>();
                    result.put(identification, invoicesForProduct);
                }

                invoicesForProduct.add(invoice);
            }
        }

        return result;

    }
}
