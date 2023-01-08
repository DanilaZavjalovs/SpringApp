package com.local.springproject.statistics;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_statistics")
public class UserStatistics implements Comparable<UserStatistics> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(UserStatistics o) {
        if(getCount() == o.getCount())
            return 0;
        else if(getCount() > o.getCount())
            return -1;
        else
            return 1;
    }
}
