package cn.ffideal.order.pojo;


public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;

    public Order() {
    }

    public Order(Long id, Long price, String name, Integer num, Long userId, User user) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.num = num;
        this.userId = userId;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +"\n" +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}