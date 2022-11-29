USE eksamensprojekt;
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('1','1','tuesday','breakfast');
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('2','2','tuesday','breakfast');

INSERT INTO meal_plan (meal_plan_name, meal_id) VALUES ('TestMealPlan','1');
INSERT INTO meal_plan (meal_plan_name, meal_id) VALUES ('TestMealPlan2','2');

INSERT INTO user_meal_plan (user_name, meal_plan_name) VALUES ('user','TestMealPlan');
INSERT INTO user_meal_plan (user_name, meal_plan_name) VALUES ('user','TestMealPlan2');
