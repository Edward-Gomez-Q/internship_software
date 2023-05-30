import 'package:flutter/material.dart';

class BottomBarCompany extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return BottomAppBar(
      color: Colors.blue.shade900,
      child: Container(
        height: 50,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            IconButton(
              onPressed: () {},
              icon: Icon(
                Icons.home,
                color: Colors.white,
              ),
              tooltip: 'Inicio',
            ),
            IconButton(
              onPressed: () {},
              icon: Icon(
                Icons.add_circle,
                color: Colors.white,
              ),
              tooltip: 'Publicar',
            ),
          ],
        ),
      ),
    );
  }
}
