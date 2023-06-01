import 'package:flutter/material.dart';
import 'package:file_picker/file_picker.dart';

class WraperPostIntership2 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(20),
      child: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Row(
              children: [
                Text('Descripción detallada',
                    style: TextStyle(fontSize: 20, color: Colors.grey.shade600),
                    textAlign: TextAlign.left),
                SizedBox(
                  width: 20,
                ),
                ElevatedButton(
                  onPressed: () async {
                    FilePickerResult? result =
                        await FilePicker.platform.pickFiles();
                    if (result != null) {
                      PlatformFile file = result.files.first;
                    } else {
                      AlertDialog(
                        title: Text('Error'),
                        content: Text('No se pudo cargar el archivo'),
                        actions: [
                          TextButton(
                            onPressed: () {
                              Navigator.of(context).pop();
                            },
                            child: Text('Ok'),
                          )
                        ],
                      );
                    }
                  },
                  child: Text('Cargar PDF'),
                  style: ElevatedButton.styleFrom(
                    primary: Color.fromARGB(255, 9, 123, 16),
                    onPrimary: Colors.white,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),
              ],
            ),
            SizedBox(
              height: 20,
            ),
            Row(
              children: [
                Text('Silabo de hoja de vida',
                    style: TextStyle(fontSize: 20, color: Colors.grey.shade600),
                    textAlign: TextAlign.left),
                SizedBox(
                  width: 20,
                ),
                ElevatedButton(
                  onPressed: () async {
                    FilePickerResult? result =
                        await FilePicker.platform.pickFiles();
                    if (result != null) {
                      PlatformFile file = result.files.first;
                    } else {
                      AlertDialog(
                        title: Text('Error'),
                        content: Text('No se pudo cargar el archivo'),
                        actions: [
                          TextButton(
                            onPressed: () {
                              Navigator.of(context).pop();
                            },
                            child: Text('Ok'),
                          )
                        ],
                      );
                    }
                  },
                  child: Text('Cargar WORD'),
                  style: ElevatedButton.styleFrom(
                    primary: Color.fromARGB(255, 9, 123, 16),
                    onPrimary: Colors.white,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),
              ],
            ),
            SizedBox(
              height: 20,
            ),
            Row(
              children: [
                Text('Formación del pasante',
                    style: TextStyle(fontSize: 20, color: Colors.grey.shade600),
                    textAlign: TextAlign.left),
                SizedBox(
                  width: 20,
                ),
                ElevatedButton(
                  onPressed: () {},
                  child: Text("Seleccionar"),
                  style: ElevatedButton.styleFrom(
                    primary: Colors.blue.shade900,
                    onPrimary: Colors.white,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),
              ],
            ),
            SizedBox(
              height: 20,
            ),
            TextFormField(
              decoration: InputDecoration(
                hintText: "Requisitos",
                hintStyle: TextStyle(color: Colors.grey),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
            SizedBox(
              height: 30,
            ),
            ElevatedButton(
              onPressed: () {
                showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      title: Text('¿Esta seguro de publicar la pasantía?'),
                      content: Text(
                          'Ha completado el formulario de publicación de pasantía.'),
                      actions: [
                        TextButton(
                          child: Text('Cancelar'),
                          onPressed: () {
                            Navigator.of(context).pop();
                          },
                        ),
                        TextButton(
                          child: Text('Publicar'),
                          onPressed: () {},
                        ),
                      ],
                    );
                  },
                );
              },
              child: Text("Publicar"),
              style: ElevatedButton.styleFrom(
                primary: Colors.blue.shade900,
                onPrimary: Colors.white,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
