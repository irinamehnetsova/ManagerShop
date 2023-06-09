package org.example;

public class ProductManager {
    protected RepositoryProduct repositoryProduct;

    public ProductManager(RepositoryProduct repositoryProduct) {
        this.repositoryProduct = repositoryProduct;

    }

    public void add(Product product) {
        repositoryProduct.save(product);
    }

    public RepositoryProduct getRepositoryProduct() {
        return repositoryProduct;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repositoryProduct.getItems()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product; // "добавляем в конец" массива result продукт product
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
