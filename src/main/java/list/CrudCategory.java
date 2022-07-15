package list;

import models.Category;

import java.util.ArrayList;
import java.util.List;

public class CrudCategory {
  public List<Category> categoryList = new ArrayList<>();

  public CrudCategory() {
    categoryList.add(new Category(1,"Model"));
    categoryList.add(new Category(2,"Student"));
  }
}
