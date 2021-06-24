/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import lapr.project.gpsd.model.Category;

/**
 *
 * @author Utilizador
 */
public class CategoryRecords {
    
    /**
     * List of categories
     */
    private List<Category> categoryList = new ArrayList<>();
    
    /**
     * Returns the list with the categories 
     * 
     * @return categories list
     */
    public List<Category> getCategoryList(){
        ArrayList<Category> catList = new ArrayList<>();
        for(Category cat: this.categoryList) {
            catList.add(cat);
        }
        return catList;
    }
    
    /**
     * Returns category by its id
     * 
     * @param strId id to be searched
     * @return category with the wanted id
     */
    public Category getCategoryById(String strId)
    {
        for(Category cat : this.categoryList)
        {
            if (cat.hasId(strId))
            {
                return cat;
            }
        }
        
        return null;
    }

    /**
     * Creates a returns a new category
     * 
     * @param strID id of the category
     * @param strDescription description of the category
     * @return new category
     */
    public Category newCategory(String strID, String strDescription)
    {
        return new Category(strID, strDescription);
    }

    /**
     * Registers a new category
     * 
     * @param category category to be registered
     * @return boolean that indicates if the category was registered
     */
    public boolean registerCategory(Category category)
    {
        if (this.validateCategory(category))
        {
            return addCategory(category);
        }
        return false;
    }

    /**
     * Adds a new category to the list
     * 
     * @param category category to be added
     * @return boolean that indicates if the category was added
     */
    public boolean addCategory(Category category)
    {
        return this.categoryList.add(category);
    }
    
    /**
     * Validates the category received
     * 
     * @param category category received
     * @return 
     */
    public boolean validateCategory(Category category)
    {
        return !categoryList.contains(category);
    }
    
    /**
     * Returns the list of categories
     * 
     * @return list of ctegories
     */
    public List<Category> getCategories()
    {
        List<Category> lc = new ArrayList<>();
        lc.addAll(this.categoryList);
        return lc;
    }
}
