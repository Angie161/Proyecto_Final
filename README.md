# 📖 Proyecto_Final

<p align="center">
  <a href="https://github.com/DenverCoder1/readme-typing-svg"><img src="https://readme-typing-svg.herokuapp.com?font=Time+New+Roman&color=%FF90BB90&size=25&center=true&vCenter=true&width=600&height=100&lines=Death's+Mission;Ce+travail+était+amusant;Cela+fait+des+merveilles;GitHub+est+incroyable"></a>
</p>

### 📋 Descripción e instrucciones de uso de la Interfaz.
Esto es un videojuego donde la muerte, el jugador, se encuentra en el limbo y es la encargada de recibir las defunciones del mundo terrenal como fragmentos de almas, la moneda del juego, además de gestionar las almas de los demonios y ángeles que van apareciendo en el limbo y decidir que hacer con ellas.
Las almas de los demonios y ángeles pueden ser empujadas, y de esa manera, hacerles caer al infierno para recibir fragmentos del almas acambio. Tambien, en el mausoleo, se pueden enviar demonios al mundo terrenal con la ayuda de ángeles, lo que alterará la cantidad de muertes que suceden allí. Las almas de los demonios, ángeles y personas se pueden guardar en los contenedores sobrenaturales para permitir que se sigan generando más en el caso de que no querramos hacerles caer al infierno. Y por último, todas las almas se pueden fusionar entre si, en el cielo, para crear nuevas almas más valiosas.

Tambien si desea probar las funcionalidades del juego y no tener que darse el tiempo de jugar mucho, puede ir a la rama "AdminBranch" y allí contará con todo lo necesario para probar todas las funcionalidades, ya que la velocidad a la que ocurren algunos eventos del juego (destrucciones de estructuras, exorcismos, muertes) es más rapida y contara con mucho dinero al inicio.

La muerte.
* Es el jugador y tiene asociada una cantidad de fragmentos de almas y un poder, lo que le permite desbloquear mejoras.

Las almas de los ángeles.

* Aparecen en el limbo, hay varios tipos, se pueden empujar al infierno lo que entregará fragmentos de almas a la muerte dependiendo del tipo que sean, la bondad que tengan y el color de sus aureolas. Por último se pueden usar en el cielo para conseguir almas de personas fusionandola con una de una persona o una de un demonio.

Las almas de los demonios.

* Aparecen en el limbo, hay varios tipos, se pueden empujar al infierno lo que entregará fragmentos de almas a la muerte dependiendo del tipo que sean, la maldad que tengan y el color de sus cuernitos. Por ultimo se pueden usar en el cielo para conseguir almas de personas fusionandola con una de una persona o una de un ángel.

Las almas de las personas.

* Se pueden conseguir al fusionar otras almas en el cielo, o muy rara vez pueden aparecer en el Limbo, y son arrojables al infierno. Su precio depende de su maldad, bondad y color de ojos.

El mausoleo.

* Aqui la muerte puede decidir enviar demonios al mundo terrenal, subir su poder, reparar el puente y reparar o mejorar la barca para enviar a los demonios y ver sus estadísticas.


### 📝 UML

Avance en el UML: Modificaciones en clases del uml en el package interfaz, agregado de clases al uml de Gametools y de las Factories.

![image](https://github.com/Angie161/Proyecto_Final/assets/146099263/a20f4f6b-5e93-46f0-aff1-6ab97b5d752e)

![image](https://github.com/Angie161/Proyecto_Final/assets/146099263/034d5afc-7e89-456a-8a3d-f811f3d3c160)

![image](https://github.com/Angie161/Proyecto_Final/assets/146099263/2744b13d-bb26-4d32-af51-f667b90c4e3d)

![image](https://github.com/Angie161/Proyecto_Final/assets/146099263/7f116839-1e63-4948-b444-3c6f09430a97)


Imagen del uml completo:

![Uml](https://github.com/Angie161/Proyecto_Final/assets/146099263/e2841786-b65d-43b1-a460-3f2b6f9dd483)


### 📍Casos de Uso
![image](https://github.com/Angie161/Proyecto_Final/assets/146099263/c1ed6784-3f1d-4b6e-9f45-7de9d3384bae)


### 📚Patrones Implementados
1. Factory: Implementamos el patrón *Factoy* para la creación aleatoria de almas en la clase 'AlmasFactory' y sus subclases, permitiendonos llamar su método de 'crearAlmas()' y generando así uno de los distintos subtipos, como angeles, demonios o personas, con stats aleatorios seleccionados de igual manera dentro de estas clases.

2. Singletón: Hicimos que la clase 'Ventana', perteneciente al package de la interfaz, implementase este patrón para así simplificar la tarea de repintarla cada que se tiene nueva información en los páneles de esta.


### 💻 Interfaz Gráfica

Esta es una imagen con la interfaz al ejecutar el programa. 

![image](https://github.com/Angie161/Proyecto_Final/assets/146099263/3774fb80-5934-4a8f-8b54-fd181241f7f3)


Esta es una imagen con la interfaz que se muestra al entrar al Mausoleo.

![image](https://github.com/Angie161/Proyecto_Final/assets/146099263/8d921324-6e1f-4661-acde-1eda2c5edf56)


### 🔍 Desiciones tomadas


### 🔍 Problemas encontrados
A lo largo del proyecto, el principal problema al que nos enfrentamos fue generar un sistemas de hitboxs adecuado y funcional para que se reconociesen las colisiones de manera idónea, pero tras una serie de pruebas y versiones logramos ajustarlo como queríamos.
De la misma manera, fue complicado configurar la forma en la que se pintaban los elementos del juego para que se mostrasen en la posición esperada, ya que se solían sobreponer entre sí, por lo que tuvimos que ser bastante minuciosos y cuidadosos con los métodos _paint()_ y _paintComponent()_.

### 🕹️ Requisitos
* Pantalla 1920 x 1080
* Procesador con velocidad base de 2.8 GHz


### 🤝🏻 Contribuidores (Grupo 20)

* 🌠 Angie Ramírez 
  
  [LinkedIn](https://www.linkedin.com/in/angie-ramirez-7417b2242/)
  
* ☄ Walter Zárate 
  
  [LinkedIn](https://www.linkedin.com/in/walter-andrés-zárate-solar-16784b243/)

<details>
<summary> <b> GitHub Stats</b></summary> 
<p align="center">
  <img  src="https://github-readme-stats.vercel.app/api?username=angie161&show_icons=true&hide_border=true&line_height=20&bg_color=0,fd6e82,fc977f&theme=graywhite"/>
  <img  src="https://github-readme-stats.vercel.app/api?username=rhussu&show_icons=true&hide_border=true&line_height=20&bg_color=0,fc977f,ffdd3f&theme=graywhite"/>
</p>
</details>

![fondo-dino](https://github.com/Angie161/Tarea_1/assets/146099765/e2be2eb8-e713-4d04-97fb-bb1f2bc89fa8)
