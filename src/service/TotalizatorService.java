package service;

import entity.Client;
import entity.ItemSale;
import entity.Sale;
import entity.Seller;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;


public class TotalizatorService {

    public void readFiles() throws IOException {
        String dir_in = "C:\\dados\\in";
        String[] pathnames;

        File directory = new File(dir_in);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        FilenameFilter filter = (directory1, name) -> name.endsWith(".dat");
        pathnames = directory.list(filter);

        assert pathnames != null;
        for (String pathname : pathnames) {
            List<Client> clients = new ArrayList<>();
            List<ItemSale> itemSales = new ArrayList<>();
            List<Seller> sellers = new ArrayList<>();

            String full = dir_in + "\\" + pathname;
            FileReader item = new FileReader(full);

            BufferedReader bufferedReader = new BufferedReader(item);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                List<String> values = Arrays.asList(line.split(";"));

                switch (values.get(0)) {
                    case "001":
                        Seller v = new Seller(
                                values.get(1),
                                values.get(2),
                                new BigDecimal(values.get(3)));
                        sellers.add(v);
                        break;
                    case "002":
                        clients.add(new Client(
                                values.get(1),
                                values.get(2),
                                values.get(3))
                        );
                        break;
                    case "003":
                        BigDecimal price = new BigDecimal(values.get(4));
                        int amountItem = Integer.parseInt(values.get(3));
                        itemSales.add(new ItemSale(
                                Long.parseLong(values.get(1)),
                                Long.parseLong(values.get(2)),
                                amountItem,
                                price,
                                values.get(5),
                                price.multiply(new BigDecimal(values.get(3)))
                        ));
                        break;
                    default:
                }

            }
            writeTotalizers(pathname, clients, itemSales, sellers);
        }


    }

    public void writeTotalizers(String fileName, List<Client> clients, List<ItemSale> itemSales, List<Seller> sellers) throws IOException {
        String dirOut = "C:\\dados\\out\\";
        String separator = ";";
        Long idSale;
        String sellerName;

        List<Sale> sales = getSalesByItems(itemSales);

        for (Sale sale: sales) {
            for (Seller seller : sellers) {
                if (seller.getName().equals(sale.getSeller())) {
                    seller.increaseTotalSales(sale.getTotal());
                    break;
                }
            }
        }

        Comparator<Seller> sellerComparator = Comparator.comparing(Seller::getTotalSales);
        sellers.sort(sellerComparator);

        sellerName = sellers.get(0).getName();
        idSale = sales.get(0).getId();

        try {
            File directory = new File(dirOut);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String content =
                    clients.size() + separator + 
                    sellers.size() + separator +
                    idSale + separator +
                    sellerName;

            File file = new File(dirOut + fileName + ".proc");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.close();

        } catch (IOException | NullPointerException e) {
            File file = new File("file_errs\\" + fileName + ".error");
            file.createNewFile();
            e.printStackTrace();
        }
    }

    private List<Sale> getSalesByItems(List<ItemSale> itemSales) {
        List<Sale> sales = new ArrayList<>();
        for (ItemSale itemSale : itemSales) {
            boolean hasSale = false;
            for (Sale sale : sales) {
                if (sale.getId().equals(itemSale.getId_sale())) {
                    hasSale = true;
                    sale.increaseAmount(itemSale.getTotal());
                    break;
                }
            }
            if (!hasSale) {
                sales.add(new Sale(
                        itemSale.getId_sale(),
                        itemSale.getTotal(),
                        itemSale.getSellerName()
                ));
            }
        }

        Comparator<Sale> saleComparator = Comparator.comparing(Sale::getTotal);
        sales.sort(Collections.reverseOrder(saleComparator));
        return sales;
    }
}
