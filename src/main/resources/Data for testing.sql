USE eksamensprojekt;
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('1','1','tuesday','breakfast');
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('2','2','tuesday','breakfast');
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('3','123','friday','lunch');
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('4','321','wedneysday','dinner');
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('5','223','wedneysday','snack');
INSERT INTO meal (meal_id, recipe_id, day, type) VALUES ('6','322','thursday','dinner');

INSERT INTO meal_plan (meal_plan_id, meal_plan_name, meal_id) VALUES ('1','TestMealPlan','1');
INSERT INTO meal_plan (meal_plan_id, meal_plan_name, meal_id) VALUES ('2','TestMealPlan2','2');
INSERT INTO meal_plan (meal_plan_id, meal_plan_name, meal_id) VALUES ('3','TestMealPlan','3');
INSERT INTO meal_plan (meal_plan_id, meal_plan_name, meal_id) VALUES ('4','TestMealPlan','4');
INSERT INTO meal_plan (meal_plan_id, meal_plan_name, meal_id) VALUES ('5','TestMealPlan2','5');
INSERT INTO meal_plan (meal_plan_id, meal_plan_name, meal_id) VALUES ('6','TestMealPlan','6');

INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','1');
INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','2');
INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','3');
INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','4');
INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','5');
INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','6');
