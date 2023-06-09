import 'package:flutter/material.dart';

class MyAppBar extends StatelessWidget implements PreferredSizeWidget {
  final String title;

  const MyAppBar({Key? key, required this.title}) : super(key: key);
  @override
  Size get preferredSize => const Size.fromHeight(80);
  @override
  Widget build(BuildContext context) {
    return AppBar(
      title: Text(title, style: TextStyle(color: Colors.white)),
      centerTitle: true,
      backgroundColor: Colors.transparent,
      flexibleSpace: Container(
        decoration: BoxDecoration(
          image: DecorationImage(
            image: AssetImage("assets/appbar(1).jpg"),
            fit: BoxFit.cover,
          ),
        ),
      ),
      elevation: 0.0,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.vertical(
          bottom: Radius.circular(30),
        ),
      ),
    );
  }
}
