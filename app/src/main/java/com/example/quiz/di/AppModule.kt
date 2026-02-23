package com.example.quiz.di

import com.example.quiz.data.AuthRepository
import com.example.quiz.data.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Ensina o Hilt a criar a instância do Firebase Auth
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    // Ensina o Hilt que, quando alguém pedir um AuthRepository (Interface),
    // ele deve entregar um AuthRepositoryImpl (Implementação real)
    @Provides
    @Singleton
    fun provideAuthRepository(
        auth: FirebaseAuth
    ): AuthRepository {
        return AuthRepositoryImpl(auth)
    }
}