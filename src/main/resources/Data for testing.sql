USE eksamensprojekt;

INSERT INTO meal_plan (meal_plan_id, meal_plan_name) VALUES ('1','TestMealPlan1');
INSERT INTO meal_plan (meal_plan_id, meal_plan_name) VALUES ('2','TestMealPlan2');
INSERT INTO meal_plan (meal_plan_id, meal_plan_name) VALUES ('3','TestMealPlan3');

INSERT INTO meal (meal_id, meal_plan_id, recipe_id, day, type) VALUES ('1','3','1','tuesday','breakfast');
INSERT INTO meal (meal_id, meal_plan_id, recipe_id, day, type) VALUES ('2','1','2','tuesday','breakfast');
INSERT INTO meal (meal_id, meal_plan_id, recipe_id, day, type) VALUES ('3','1','123','friday','lunch');
INSERT INTO meal (meal_id, meal_plan_id, recipe_id, day, type) VALUES ('4','2','321','wedneysday','dinner');
INSERT INTO meal (meal_id, meal_plan_id, recipe_id, day, type) VALUES ('5','2','223','wedneysday','snack');
INSERT INTO meal (meal_id, meal_plan_id, recipe_id, day, type) VALUES ('6','2','322','thursday','dinner');

INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','1');
INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','2');
INSERT INTO user_meal_plan (user_name, meal_plan_id) VALUES ('user','3');