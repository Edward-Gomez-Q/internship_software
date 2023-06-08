import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:intership_frontend/bloc/cubit/company_cubit.dart';
import 'package:intership_frontend/bloc/states/company_state.dart';
import 'package:intership_frontend/screens/company/company_register.dart';
import 'package:intership_frontend/screens/company/message.dart';

class WraperCompanyRegister2 extends StatelessWidget {
  const WraperCompanyRegister2({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return BlocBuilder<CompanyCubit,CompanyState>(
      builder: (context, state) {
        return Padding(
          padding: EdgeInsets.all(20),
          child: SingleChildScrollView(
            child: Column(
              children: <Widget>[
                Text("Registro de constacto de la empresa",
                    style: TextStyle(
                        color: Colors.black.withOpacity(0.4),
                        fontSize: 20,
                        fontWeight: FontWeight.bold)),
                SizedBox(
                  height: 20,
                ),
                TextField(
                  decoration: InputDecoration(
                    hintText: "Nombre de la persona de contacto",
                    hintStyle: const TextStyle(color: Colors.grey,
                    ),
                    icon: Icon(Icons.person),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) {
                    BlocProvider.of<CompanyCubit>(context).updateNombresContacto(value);
                  },
                ),
                SizedBox(
                  height: 20,
                ),
                TextField(
                  decoration: InputDecoration(
                    hintText: "Primer apellido",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.person),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) {
                    BlocProvider.of<CompanyCubit>(context).updatePrimerApellidoContacto(value);
                  },
                ),
                SizedBox(
                  height: 20,
                ),
                TextField(
                  decoration: InputDecoration(
                    hintText: "Segundo apellido",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.person),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) {
                    BlocProvider.of<CompanyCubit>(context).updateSegundoApellidoContacto(value);
                  },
                ),
                SizedBox(
                  height: 20,
                ),
                TextField(
                  decoration: InputDecoration(
                    hintText: "Correo electrónico",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.email),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) {
                    BlocProvider.of<CompanyCubit>(context).updateCorreoElectronicoContacto(value);
                  },
                ),
                SizedBox(
                  height: 20,
                ),
                TextField(
                  decoration: InputDecoration(
                    hintText: "Teléfono",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.phone),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) {
                    BlocProvider.of<CompanyCubit>(context).updateTelefonoContacto(value);
                  },
                ),
                SizedBox(
                  height: 20,
                ),
                TextField(
                  decoration: InputDecoration(
                    hintText: "Contraseña",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.phone),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) {
                    BlocProvider.of<CompanyCubit>(context).updateContrasena(value);
                  },
                ),
                SizedBox(
                  height: 20,
                ),
                TextField(
                  decoration: InputDecoration(
                    hintText: "Confirmar contraseña",
                    hintStyle: TextStyle(color: Colors.grey),
                    icon: Icon(Icons.phone),
                    border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                  onChanged: (value) {
                    BlocProvider.of<CompanyCubit>(context).updateConfirmarContrasena(value);
                  },
                ),
                SizedBox(
                  height: 20,
                ),
                Row(
                  children: [
                    ElevatedButton(
                      onPressed: () {
                        Navigator.push(
                            context,
                            MaterialPageRoute(
                                builder: (context) => RegisterCompany()));
                      },
                      child: Text("Atras"),
                      style: ElevatedButton.styleFrom(
                        primary: Colors.red.shade900,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 20,
                    ),
                    ElevatedButton(
                      onPressed: () {
                        print(state.toString());
                        Navigator.push(context,
                            MaterialPageRoute(builder: (context) => Message()));
                      },
                      child: Text("Registrar"),
                      style: ElevatedButton.styleFrom(
                        primary: Colors.blue.shade900,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                        ),
                      ),
                    ),
                  ],
                )
              ],
            ),
          ),
        );
      },
    );

  }
}
