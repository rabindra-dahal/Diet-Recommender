package com.dietManager.recommendation.algorithmImpl;

import com.dietManager.database.InformationDetailer.NutritionInformationProvider;
import com.dietManager.database.Nutrition.FoodBAO.FoodBAOInterfaceImpl;
import com.dietManager.model.Nutrition.Food;
import java.util.ArrayList;
import java.util.List;

public class DietDataModel {
    /*
        select n.n_name,c.amount,
        n.unit
        from contains c,nutrients n
        where
        c.n_id=n.n_id and c.f_id=1;
        
        select c.f_id FoodId,c.n_id NutritionId,n.n_name NutritionName,c.amount NutrientAmount,
        n.unit NutritionUnit
        from contains c,nutrients n
        where
        c.n_id=n.n_id and c.f_id=1
        
    
        select f.f_name foodName,c.c_name categoryName from food f,categories c,belongs b
        where
        f.f_id=b.f_id
        and
        b.c_id=c.c_id
        and
        f.f_id=1
    
    select f.f_name foodName,c.c_name categoryName from food f,categories c,belongs b
        where
        f.f_id=b.f_id
        and
        b.c_id=c.c_id
        and
        c.c_name='Cereals'
/


    */

    public static void main(String[] args) throws Exception {
        KarlPearsonSimilarity ks=new KarlPearsonSimilarity();
        List<String> s;
        s=ks.recommendDiet("./src/java/com/dietManager/recommendation/algorithmImpl/test1.csv", 25, 10);
        for(String rec:s){
         
            FoodBAOInterfaceImpl fb=new FoodBAOInterfaceImpl();
            Food f=fb.foodFindByPK(Double.parseDouble(rec));
            System.out.println(f.getF_name());
        
        }
        /*NutritionInformationProvider n=new NutritionInformationProvider();
        List<NutritionInformationProvider> nl=n.findFoodNutritionInformation(1);
        for(NutritionInformationProvider m:nl)
        {
            //System.out.println("Food Id "+m.getF_id());
            //System.out.println("Nutrition Id "+m.getN_id());
            System.out.print(" "+m.getN_name());
            System.out.print(" \t"+m.getAmount());
            System.out.println(" \t"+m.getUnit());
        }*/
        //NutritionInformationProvider nf=new NutritionInformationProvider();
        
        /*FoodInformationProvider f=new FoodInformationProvider();
        //f.setF_id(1);
        f.findFoodCategoryInformation(1);
        System.out.println(f);
        System.out.print(" "+f.getF_name());
        System.out.println("\t "+f.getC_name());*/
       /* KarlPearsonSimilarity ks=new KarlPearsonSimilarity();
        List<Food> f=ks.obtainRecommendedFoodNameForUserId(10, 10);
        for(Food rec:f)
        {
            System.out.println(rec.getF_name());
        }*/
        //System.out.println((long)(Math.random()*1000*5));
        
    }
}
