package pl.edu.pwr.mateusznowak.lab1.swim_lab2.dagger

import dagger.Module
import dagger.Provides
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.MoviesHelper
import javax.inject.Singleton

/**
 * Created by Mateusz on 01.05.2017.
 */
@Module
class MoviesModule {

    @Provides @Singleton fun provideMovieHelper() = MoviesHelper()
}