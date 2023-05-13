package org.example;

public class RepositoryProduct {
    private Product[] items = new Product[0];


    public void save(Product item) {

        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] getItems() {
        return items;
    }

    public void delete(int id) {
        if (this.findById(id) == null) {
            NotFoundException e = new NotFoundException(
                    "ID не найден:" + id
            );
            throw e;
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
