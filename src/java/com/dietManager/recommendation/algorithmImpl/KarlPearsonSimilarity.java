package com.dietManager.recommendation.algorithmImpl;

import com.dietManager.database.Nutrition.FoodBAO.FoodBAOInterfaceImpl;
import com.dietManager.model.Nutrition.Food;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class KarlPearsonSimilarity {
    /*
    @param path
        Give the path where test file is located
    @param UserId
        UserId to whom item is to be recommended
    @param recommendedItemNo
        Total number of item to be recommended for UserId
    
    */

    public List<String> recommendDiet(String path, long UserId, int recommendedItemNo) {
        List<String> rec = new ArrayList<>();
        try {

// open the data set
            DataModel model = new FileDataModel(new File(path));

// create an ItemSimilarity object for testing similarity
            ItemSimilarity sim = new PearsonCorrelationSimilarity(model);
// Create an Item Based recommender using the model and log
//likelihood similarity measure
            Recommender recommender = new GenericItemBasedRecommender(model, sim);
// no neighborhood is necessary as with user-based similarity
// produce numRecommendations for userId
            for (RecommendedItem recommendation : recommender.recommend(UserId, recommendedItemNo)) {
                rec.add("" + recommendation.getItemID());
            }

        } catch (IOException | TasteException ex) {
            Logger.getLogger(KarlPearsonSimilarity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rec;

    }
    public List<Food> obtainRecommendedFoodNameForUserId(String filepath,long uid,int rec_no) throws Exception{
        List<Food> list=new ArrayList<>();
         KarlPearsonSimilarity ks=new KarlPearsonSimilarity();
        List<String> s;
        s=ks.recommendDiet(filepath, uid, rec_no);
        for(String rec:s){
         
            FoodBAOInterfaceImpl fb=new FoodBAOInterfaceImpl();
            Food f=fb.foodFindByPK(Double.parseDouble(rec));
            f.setF_name(f.getF_name());
            f.setF_id(f.getF_id());
            list.add(f);
        
        }
        return list;
    }
    

}
