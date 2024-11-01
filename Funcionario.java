package entrega1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import java.util.InputMismatchException;

public class Funcionario {
    private String nome;
    private long cpf;
    private String cargo;
    private double sal; //salário
    private String turno; //turno do trabalho
    
    static ArrayList<Funcionario> lista = new ArrayList<>();
    
    public Funcionario(String nome, long cpf, String cargo, double sal, String turno) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.sal = sal;
        this.turno = turno;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Funcionario that = (Funcionario) obj;
        return cpf == that.cpf && nome.equals(that.nome) && cargo.equals(that.cargo) && sal == that.sal && turno.equals(that.turno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, cargo, sal, turno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public void divide() {
    	System.out.println("— — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — — \n");
    }
    
    public void cadastro() {
        Scanner sc = new Scanner(System.in);
        boolean v = false;
        double tax, h; // taxa por hora trabalhada e horas trabalhadas, pra calcular o salário
        
        divide();
        System.out.println("\nCADASTRO DE NOVO FUNCIONÁRIO\n");

        System.out.print("Nome: ");
        this.nome = sc.next();

        do {
            try {
                System.out.print("CPF (11 dígitos): ");
                this.cpf = sc.nextLong();
                sc.nextLine();
                
                if (String.valueOf(cpf).length() == 11) {
                	v = true;
                    for (Funcionario f : lista) {
                        if (f.getCpf() == this.cpf) {
                            System.out.println("Esse CPF já está cadastrado. Tente novamente.");
                            v = false;
                            break;
                        }
                        
                    }
                } else {
                    System.out.println("CPF inválido. Deve ter 11 dígitos.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine(); 
            }
        } while (!v);

        System.out.print("Cargo: ");
        this.cargo = sc.nextLine();

        do {
            try {
                System.out.print("\nCÁLCULO DE SALÁRIO\n\nHoras trabalhadas no mês: ");
                h = sc.nextDouble();
                System.out.print("\nTaxa de pagamento por hora em reais: ");
                tax = sc.nextDouble();
                this.sal = tax * h;
                System.out.print(String.format("R$ %.2f", this.sal));
                v = true;
                
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine(); 
                v = false;
                
            }
        } while (!v);

        do {
            try {
                System.out.println("\n\nTurno do trabalho:\n(1) Manhã  (2) Tarde  (3) Noite  (4) Madrugada");
                int imp = sc.nextInt();
                
                switch (imp) {
                    case 1: 
                    	this.turno = "Manhã"; 
                    	break;
                    
                    case 2: 
                    	this.turno = "Tarde"; 
                    	break;
                    
                    case 3: 
                    	this.turno = "Noite"; 
                    	break;
                    
                    case 4: 
                    	this.turno = "Madrugada"; 
                    	break;
                    
                    default: 
                    	System.out.println("Opção inválida. Tente novamente.");
                    	v = false;
                    	continue;
                }
                System.out.println(getTurno());
                System.out.println("\nOperação concluída com sucesso.\n");
                divide();
                v = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                sc.nextLine();
                v = false;
            }
        } while (!v);

        lista.add(new Funcionario(this.nome, this.cpf, this.cargo, this.sal, this.turno));
    }

    public void view() {
      	divide();
    	
    	if (lista.isEmpty()) {
        	System.out.println("\nZero cadastros.\n");
        } else {
        	int ind = 1; // um índice pra melhorar a visualização
        	for (Funcionario f : lista) {	
        		System.out.println("\nN° " + ind + " ——— Nome: " + f.getNome() + "  CPF: " + f.getCpf() + "  Cargo: " + f.getCargo() + "  Salário: R$ " + String.format("%.2f", f.getSal()) + "  Turno: " + f.getTurno() + "\n");        		
        		ind++;
        	}
      }
    	divide();
    }
    

	public void edit() {
    	Scanner sc = new Scanner(System.in);
    	double tax, h;
    	divide();
    	boolean t = false;
    	
    	if (!lista.isEmpty()) {
        	System.out.print("\nDigite o CPF do funcionário: ");
        	long comp = sc.nextLong();
        	sc.nextLine();
    		if (String.valueOf(comp).length() == 11) {
    			for (Funcionario f : lista) {
    				if (f.getCpf() == comp) {
    					System.out.println("\nNome: " + f.getNome() + "  Cargo: " + f.getCargo() + "  Salário: R$ " + String.format("%.2f", f.getSal()) + "  Turno: " + f.getTurno());
    					System.out.println("\nReescreva os dados do funcionário.\n");
    					System.out.print("Nome: ");
    					f.setNome(sc.nextLine());
    					
    					do {
    					    try {
    					        System.out.print("CPF (11 dígitos): ");
    					        long cpf = sc.nextLong(); 
    					        sc.nextLine(); 

    					        if (String.valueOf(cpf).length() == 11) {
    					            t = true; 
 					            
    					            if (f.getCpf() != cpf) { 
    					                for (Funcionario f1 : lista) {
    					                    if (f1.getCpf() == cpf) { 
    					                        System.out.println("Esse CPF já está cadastrado. Tente novamente.");
    					                        t = false; 
    					                        break;
    					                    }
    					                }
    					            }
    					        } else {
    					            System.out.println("CPF inválido. Deve ter 11 dígitos.");
    					        }
    					    } catch (InputMismatchException e) {
    					        System.out.println("Entrada inválida. Tente novamente.");
    					        sc.nextLine(); 
    					    }
    					    f.setCpf(cpf);
    					} while (!t); 
    					
    					System.out.print("Cargo: ");
    					f.setCargo(sc.nextLine());
    					do {
    						try {
    							System.out.print("\nCÁLCULO DE SALÁRIO\n\nHoras trabalhadas no mês: ");
    							h = sc.nextDouble();
    							System.out.print("\nTaxa de pagamento por hora em reais: ");
    							tax = sc.nextDouble();
    							f.setSal(tax * h);
    							System.out.print(String.format("R$ %.2f", f.getSal()));
    							t = true;
    						} catch (InputMismatchException e) {
    							System.out.println("Entrada inválida. Tente novamente.");
    							sc.nextLine(); 
    						}
    					} while (!t);
    					do {
    			            try {
    			                System.out.println("\n\nTurno do trabalho:\n(1) Manhã  (2) Tarde  (3) Noite  (4) Madrugada");
    			                int imp = sc.nextInt();
    			                
    			                switch (imp) {
    			                    case 1: 
    			                    	f.setTurno("Manhã"); 
    			                    	break;
    			                    
    			                    case 2: 
    			                    	f.setTurno("Tarde"); 
    			                    	break;
    			                    
    			                    case 3: 
    			                    	f.setTurno("Noite"); 
    			                    	break;
    			                    
    			                    case 4: 
    			                    	f.setTurno("Madrugada");
    			                    	break;
    			                    
    			                    default: 
    			                    	System.out.println("Opção inválida. Tente novamente.");
    			                    	t = false;
    			                    	continue;
    			                }
    			                System.out.println(f.getTurno());
    			                System.out.println("\nOperação concluída com sucesso.\n");
    			                divide();
    			                t = true;
    			            } catch (InputMismatchException e) {
    			                System.out.println("Entrada inválida. Tente novamente.");
    			                sc.nextLine();
    			                t = false;
    			            }
    			        } while (!t);

    				} else {
    					if (!t) {
    						System.out.println("\nCPF não encontrado.");
    					}
    				
    				}
    			}
	    	} else {
				System.out.println("\nO CPF deve ter 11 dígitos. Voltando ao menu . . .");
	    	}
    	} else {
    		System.out.println("\nZero cadastros.");
    	}
    	divide();
    }
    public void remove() {
    	Scanner sc = new Scanner(System.in);
    	divide();
    	boolean t = false;
    	
    	if (!lista.isEmpty()) {
    		System.out.print("\nDigite o CPF do funcionário: ");
    		long comp = sc.nextLong();
    		for (int i = 0; i < lista.size(); i++) {
    			Funcionario f = lista.get(i);
    			if (f.getCpf() == comp) {
    				do {
    					try {
    						System.out.println("\nNome: " + f.getNome() + "  Cargo: " + f.getCargo() + "  Salário: R$ " + String.format("%.2f", f.getSal()) + "  Turno: " + f.getTurno());
    						System.out.println("\nVocê tem certeza que deseja removê-lo?\n\n\n(1) Sim  (2) Não");
    						int r = sc.nextInt();
    						switch (r) {
    						case 1:
    							lista.remove(f);
    							System.out.println("\nOperação concluída com sucesso.\n");
    							t = true;
    							break;
    						case 2:
    							System.out.println("\nOperação abortada.\n");
    							t = true;
    							break;
    						default:
    							System.out.println("\nOpção inválida. Tente novamente.");
    							continue;

    						}
    					} catch(InputMismatchException e) {
    						System.out.println("\nEntrada inválida. Tente novamente.");
    					}
    				} while(!t);
    			} else {
    				if (!t) {
    					System.out.println("\nCPF não encontrado.");
    				}
    			}
    		}
    	} else {
    		System.out.println("\nZero cadastros.");
    	}
    	divide();
    }
}
