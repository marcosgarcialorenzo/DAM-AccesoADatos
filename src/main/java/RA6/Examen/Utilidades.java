package RA6.Examen;

import java.util.ArrayList;

public class Utilidades {

    public void insertarDepartamento(Departamento dep) {
        if (! Datos.departamentos.contains(dep)) {
            Datos.departamentos.add(dep);
            System.out.println("Departamento insertado correctamente");
        }
        else {
            System.out.println("El ID del departamento ya existe");
        }
    }

    public void insertarEmpleado(Empleado emp) {
        if (! Datos.empleados.contains(emp)) {
            Datos.empleados.add(emp);
            System.out.println("Empleado insertado correctamente");
        }
        else {
            System.out.println("El ID del empleado ya existe");
        }
    }

    public void insertarProyecto(Proyecto pro) {
        if (! Datos.proyectos.contains(pro)) {
            Datos.proyectos.add(pro);
            System.out.println("Proyecto insertado correctamente");
        }
        else {
            System.out.println("El ID del proyecto ya existe");
        }
    }

    public void mostrarDepartamentos() {
        for (Departamento departamentos : Datos.departamentos) {
            System.out.println("ID: " + departamentos.getId());
            System.out.println("Nombre: " + departamentos.getNombre());
            System.out.println("Localidad: " + departamentos.getLoc());
            System.out.println("--");
        }
    }

    public void mostrarEmpleados() {
        for (Empleado empleados : Datos.empleados) {
            System.out.println("ID: " + empleados.getId());
            System.out.println("Apellidos: " + empleados.getApellido());
            System.out.println("Oficios: " + empleados.getOficio());
            System.out.println("Salario: " + empleados.getSalario());
            System.out.println("Departamento: " + empleados.getDeptId());
            for (String especialidades : empleados.getEspecialidades()) {
                System.out.println("    --> " + especialidades);
            }
            System.out.println("--");
        }
    }

    public void mostrarProyectos() {
        for (Proyecto proyectos : Datos.proyectos) {
            System.out.println("ID: " + proyectos.getId());
            System.out.println("Nombre: " + proyectos.getNombre());
            System.out.println("Presupuesto: " + proyectos.getPresupuesto());
            System.out.println("Departamento: " + proyectos.getDeptId());
            System.out.println("--");
        }
    }

    public void empleadoCentral() {
        int empleadosLongitud = 0;
        for (Empleado empleados : Datos.empleados) {
            empleadosLongitud++;
        }
        int empleadosCentral = empleadosLongitud / 2;
        empleadosLongitud = 0;
        for (Empleado empleados : Datos.empleados) {
            empleadosCentral++;
            if (empleadosLongitud == empleadosCentral) {
                System.out.println("ID: " + empleados.getId());
                System.out.println("Apellidos: " + empleados.getApellido());
                System.out.println("Oficios: " + empleados.getOficio());
                System.out.println("Salario: " + empleados.getSalario());
                System.out.println("Departamento: " + empleados.getDeptId());
            }
        }
    }

    public void salarioMayorMediaDep() {
        double mediaDepartamento10 = 0;
        double mediaDepartamento20 = 0;
        double mediaDepartamento30 = 0;
        double mediaDepartamento40 = 0;
        double mediaDepartamento50 = 0;
        double mediaDepartamento60 = 0;
        double mediaDepartamento70 = 0;
        double mediaDepartamento80 = 0;
        double mediaDepartamento90 = 0;
        double mediaDepartamento100 = 0;
        int contador10 = 0;
        int contador20 = 0;
        int contador30 = 0;
        int contador40 = 0;
        int contador50 = 0;
        int contador60 = 0;
        int contador70 = 0;
        int contador80 = 0;
        int contador90 = 0;
        int contador100 = 0;
        for (Empleado empleados : Datos.empleados) {
            if (empleados.getDeptId() == 10) {
                mediaDepartamento10 += empleados.getSalario();
                contador10++;
            } else if (empleados.getDeptId() == 20) {
                mediaDepartamento20 += empleados.getSalario();
                contador20++;
            } else if (empleados.getDeptId() == 30) {
                mediaDepartamento30 += empleados.getSalario();
                contador30++;
            } else if (empleados.getDeptId() == 40) {
                mediaDepartamento40 += empleados.getSalario();
                contador40++;
            } else if (empleados.getDeptId() == 50) {
                mediaDepartamento50 += empleados.getSalario();
                contador50++;
            } else if (empleados.getDeptId() == 60) {
                mediaDepartamento60 += empleados.getSalario();
                contador60++;
            } else if (empleados.getDeptId() == 70) {
                mediaDepartamento70 += empleados.getSalario();
                contador70++;
            } else if (empleados.getDeptId() == 80) {
                mediaDepartamento80 += empleados.getSalario();
                contador80++;
            } else if (empleados.getDeptId() == 90) {
                mediaDepartamento90 += empleados.getSalario();
                contador90++;
            } else if (empleados.getDeptId() == 100) {
                mediaDepartamento100 += empleados.getSalario();
                contador100++;
            }
        }
        mediaDepartamento10 = mediaDepartamento10 / contador10;
        mediaDepartamento20 = mediaDepartamento20 / contador20;
        mediaDepartamento30 = mediaDepartamento30 / contador30;
        mediaDepartamento40 = mediaDepartamento40 / contador40;
        mediaDepartamento50 = mediaDepartamento50 / contador50;
        mediaDepartamento60 = mediaDepartamento60 / contador60;
        mediaDepartamento70 = mediaDepartamento70 / contador70;
        mediaDepartamento80 = mediaDepartamento80 / contador80;
        mediaDepartamento90 = mediaDepartamento90 / contador90;
        mediaDepartamento100 = mediaDepartamento100 / contador100;
        for (Empleado empleados : Datos.empleados) {
            if (empleados.getDeptId() == 10 && empleados.getSalario() > mediaDepartamento10) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento10);
            } else if (empleados.getDeptId() == 20 && empleados.getSalario() > mediaDepartamento20) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento20);
            } else if (empleados.getDeptId() == 30 && empleados.getSalario() > mediaDepartamento30) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento30);
            } else if (empleados.getDeptId() == 40 && empleados.getSalario() > mediaDepartamento40) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento40);
            } else if (empleados.getDeptId() == 50 && empleados.getSalario() > mediaDepartamento50) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento50);
            } else if (empleados.getDeptId() == 60 && empleados.getSalario() > mediaDepartamento60) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento60);
            } else if (empleados.getDeptId() == 70 && empleados.getSalario() > mediaDepartamento70) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento70);
            } else if (empleados.getDeptId() == 80 && empleados.getSalario() > mediaDepartamento80) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento80);
            } else if (empleados.getDeptId() == 90 && empleados.getSalario() > mediaDepartamento90) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento90);
            } else if (empleados.getDeptId() == 100 && empleados.getSalario() > mediaDepartamento100) {
                System.out.println(empleados.getApellido() + " Departamento: " + empleados.getDeptId() + " Salario: " + empleados.getSalario() + " Media: " + mediaDepartamento100);
            }
        }
    }

    public void salarioMaxDep() {
        double maxDepartameto10 = 0;
        double mediaDepartamento20 = 0;
        double mediaDepartamento30 = 0;
        double mediaDepartamento40 = 0;
        double mediaDepartamento50 = 0;
        double mediaDepartamento60 = 0;
        double mediaDepartamento70 = 0;
        double mediaDepartamento80 = 0;
        double mediaDepartamento90 = 0;
        double mediaDepartamento100 = 0;
        for (Empleado empleados : Datos.empleados) {
            if (empleados.getDeptId() == 10) {
                maxDepartameto10 = empleados.getSalario();
                if (empleados.getSalario() > maxDepartameto10) {
                    maxDepartameto10 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 20) {
                mediaDepartamento20 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento20) {
                    mediaDepartamento20 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 30) {
                mediaDepartamento30 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento30) {
                    mediaDepartamento30 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 40) {
                mediaDepartamento40 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento40) {
                    mediaDepartamento40 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 50) {
                mediaDepartamento50 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento50) {
                    mediaDepartamento50 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 60) {
                mediaDepartamento60 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento60) {
                    mediaDepartamento60 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 70) {
                mediaDepartamento70 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento70) {
                    mediaDepartamento70 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 80) {
                mediaDepartamento80 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento80) {
                    mediaDepartamento80 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 90) {
                mediaDepartamento90 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento90) {
                    mediaDepartamento90 = empleados.getSalario();
                }
            } else if (empleados.getDeptId() == 100) {
                mediaDepartamento100 = empleados.getSalario();
                if (empleados.getSalario() > mediaDepartamento100) {
                    mediaDepartamento100 = empleados.getSalario();
                }
            }
        }
        for (Empleado empleados : Datos.empleados) {
            if (empleados.getDeptId() == 10) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + maxDepartameto10 + ")");
            } else if (empleados.getDeptId() == 20) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento20 + ")");
            } else if (empleados.getDeptId() == 30) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento30 + ")");
            } else if (empleados.getDeptId() == 40) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento40 + ")");
            } else if (empleados.getDeptId() == 50) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento50 + ")");
            } else if (empleados.getDeptId() == 60) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento60 + ")");
            } else if (empleados.getDeptId() == 70) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento70 + ")");
            } else if (empleados.getDeptId() == 80) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento80 + ")");
            } else if (empleados.getDeptId() == 90) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento90 + ")");
            } else if (empleados.getDeptId() == 100) {
                System.out.println("Departamento: " + empleados.getDeptId() + " --> " + empleados.getApellido() + " (" + mediaDepartamento100 + ")");
            }
        }
    }

    public void empMasDeUnProyecto() {
        for (Empleado empleados : Datos.empleados) {
            ArrayList<Proyecto> proyectos = empleados.getProyectos();
            if (proyectos.size() > 1) {
                System.out.println("Empleado: " + empleados.getApellido());
                System.out.println("Proyectos: " + proyectos.size());
                for (Proyecto proyectoss : proyectos) {
                    System.out.println("    --> " + proyectoss);
                }
            }
        }
    }

    public void proyectosMultiDept() {
        for (Proyecto proyectos : Datos.proyectos) {
            ArrayList<Empleado> empleadosProyectos = proyectos.getEmpleados();
            boolean diferente = false;
            int numDepartamentos = 0;
            for (Empleado empleados : empleadosProyectos) {
                if (empleados.getDeptId() == 10) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 20) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 30) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 40) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 50) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 60) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 70) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 80) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 90) {
                    numDepartamentos++;
                } else if (empleados.getDeptId() == 100) {
                    numDepartamentos++;
                }
                if (numDepartamentos >= 2) {
                    diferente = true;
                }
                if (diferente) {
                    System.out.println("Proyecto: " + proyectos.getNombre());
                    System.out.println("Numero de departamentos: " + numDepartamentos);
                }
            }
        }
    }

    public void empConProyectos() {
        for (Empleado empleados : Datos.empleados) {
            System.out.println(empleados.getApellido());
            ArrayList<Proyecto> proyectos = empleados.getProyectos();
            for (Proyecto proyectoss : proyectos) {
                if (proyectos.size() > 0) {
                    System.out.println("    --> " + proyectoss);
                } else {
                    System.out.println("No tiene proyectos asignados");
                }
            }
        }
    }

    public void depConEmpleados() {
        for (Departamento departamentos : Datos.departamentos) {
            System.out.println("Departamento: " + departamentos.getNombre());
            ArrayList<Empleado> empleados = departamentos.getEmpleados();
            for (Empleado empleadosss : empleados) {
                if (departamentos.getId() == empleadosss.getDeptId()) {
                    System.out.println("    --> " + empleadosss.getApellido());
                }
            }
        }
    }

    public void proyectosConEmpleados() {
        for (Proyecto proyectos : Datos.proyectos) {
            System.out.println("Proyecto: " + proyectos.getNombre());
            ArrayList<Empleado> empleados = proyectos.getEmpleados();
            for (Empleado empleadosss : empleados) {
                if (! empleadosss.getProyectos().isEmpty()) {
                    System.out.println("        --> " + empleadosss.getApellido());
                } else if (empleadosss.getProyectos().isEmpty()) {
                    System.out.println("No tiene empleados asignados");
                }
            }
        }
    }

    public void empleadosPorOficio(String oficio) {
        for (Empleado empleados : Datos.empleados) {
            if (empleados.getOficio().equalsIgnoreCase(oficio)) {
                System.out.println("ID: " + empleados.getId());
                System.out.println("Apellidos: " + empleados.getApellido());
                System.out.println("Oficio: " + empleados.getOficio());
                System.out.println("Salario: " + empleados.getSalario());
                System.out.println("--");
            }
        }
    }

    public void masDeDosEspecialidades() {
        for (Empleado empleados : Datos.empleados) {
            ArrayList<String> especialidades = empleados.getEspecialidades();
            if (especialidades.size() > 2) {
                System.out.println("Empleado: " + empleados.getApellido());
                for (String especialidadess : especialidades) {
                    System.out.println("    --> " + especialidadess);
                }
            }
            System.out.println("--");
        }
    }
}