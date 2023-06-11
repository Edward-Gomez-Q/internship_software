import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/auth_cubit.dart';
import 'package:intership_frontend/bloc/cubit/company_cubit.dart';
import 'package:intership_frontend/bloc/cubit/intership_cubit.dart';
import 'package:intership_frontend/bloc/cubit/student_cubit.dart';
import 'package:intership_frontend/bloc/cubit/token_cubit.dart';
import 'screens/login/login_principal.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiBlocProvider(
      //Aqui se agregan todos los blocs que se van a utilizar
      providers: [
        BlocProvider<StudentCubit>(create: (context) => StudentCubit()),
        BlocProvider<CompanyCubit>(create: (context) => CompanyCubit()),
        BlocProvider<IntershipCubit>(create: (context) => IntershipCubit()),
        BlocProvider<AuthCubit>(create: (context) => AuthCubit()),
        BlocProvider<TokenCubit>(create: (context) => TokenCubit()),
      ],
      child: const MaterialApp(
        debugShowCheckedModeBanner: false,
        home: LoginPrincipal(),
      ),
    );
  }
}
