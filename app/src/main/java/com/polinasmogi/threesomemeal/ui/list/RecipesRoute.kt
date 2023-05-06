package com.polinasmogi.threesomemeal.ui.list

import androidx.activity.compose.BackHandler
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.polinasmogi.threesomemeal.data.Recipe
import com.polinasmogi.threesomemeal.ui.RecipeDetails
import com.polinasmogi.threesomemeal.ui.Recipes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesRoute(
    recipesViewModel: RecipesViewModel,
    onSelectRecipe: (Recipe) -> Unit,
    onBackPressed: () -> Unit
) {
    val uiState by recipesViewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is RecipeUiState.NoRecipes -> {

        }
        is RecipeUiState.RecipeInfo -> {
            RecipeDetails(recipe = (uiState as RecipeUiState.RecipeInfo).recipe)
            BackHandler {
                onBackPressed()
            }
        }
        is RecipeUiState.RecipeList -> {
            Recipes(recipes = (uiState as RecipeUiState.RecipeList).recipes, onSelectRecipe)
        }
    }


}