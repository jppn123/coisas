package view;

import DAO.*;
import model.*;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Especialidades especialidades = new Especialidades("urologista", "tutelar");
        Especialidades especialidades1 = new Especialidades("cardiologista", "tutelarbr30");
        EspecialidadesDAO e = new EspecialidadesDAO();

        Medicos medicos = new Medicos("pedro henrique", "3213213/ce");
        Medicos medicos1 = new Medicos("robert silva", "3553443/ce");
        MedicosDAO md = new MedicosDAO();

        AtributosEstruturaLente atl = new AtributosEstruturaLente("atributo 1", "esquerdo");
        AtributosEstruturaLente atl1 = new AtributosEstruturaLente("atributo 2", "direito");
        AtributosEstruturaLenteDAO at = new AtributosEstruturaLenteDAO();

        Pacientes pacientes = new Pacientes("joao", "12321323", new Date(10));
        Pacientes pacientes1 = new Pacientes("pedro", "12621323", new Date(10));
        PacientesDAO pc = new PacientesDAO();

        EspecialidadesMedicas especialidadesMedicas = new EspecialidadesMedicas("grau olho esquerdo > direito", new Date(10), 1, 1);
        EspecialidadesMedicas especialidadesMedicas1 = new EspecialidadesMedicas("grau olho direito < esquerdo", new Date(10), 1, 1);
        EspecialidadesMedicasDAO esp = new EspecialidadesMedicasDAO();

        ConsultasMedicas consultasMedicas = new ConsultasMedicas("assinatura do medico 1", new Date(10), 1, 1);
        ConsultasMedicas consultasMedicas1 = new ConsultasMedicas("assinatura do medico 1", new Date(10), 1, 1);
        ConsultasMedicasDAO cm = new ConsultasMedicasDAO();

        ReceitasOculos receitasOculos = new ReceitasOculos("oculos de grau", new Date(10), 1);
        ReceitasOculos receitasOculos1 = new ReceitasOculos("oculos de sol + astigmatismo", new Date(10), 1);
        ReceitasOculosDAO ro = new ReceitasOculosDAO();

        ObservacoesLaudos observacoesLaudos = new ObservacoesLaudos("verificar colirio", 1);
        ObservacoesLaudos observacoesLaudos1 = new ObservacoesLaudos("verificar analgesico", 1);
        ObservacoesLaudosDAO ol = new ObservacoesLaudosDAO();

        EstruturasLentes estruturasLentes = new EstruturasLentes("astigmatismo", 2, 1);
        EstruturasLentes estruturasLentes1 = new EstruturasLentes("miopia", 3, 1);
        EstruturasLentesDAO el = new EstruturasLentesDAO();

        EspecificacoesLente especificacoesLente = new EspecificacoesLente(2.3, 1, 1);
        EspecificacoesLente especificacoesLente1 = new EspecificacoesLente(2.7, 1, 1);
        EspecificacoesLenteDAO epl = new EspecificacoesLenteDAO();

        e.insertEspecialidades(especialidades);
        System.out.println(e.selectAllEspecialidades());
        e.updateEspecialidades(especialidades1, 1);
        System.out.println(e.selectEspecialidades(1).getDescricao());
//        e.deleteEspecialidades(2);

        md.insertMedicos(medicos);
        System.out.println(md.selectAllMedicos());
        md.updateMedicos(medicos1,1);
        System.out.println(md.selectMedicos(1).getNome());
//        md.deleteMedicos(2);

        at.insertAtributosEstruturaLente(atl);
        System.out.println(at.selectAllAtributosEstruturaLente());
        at.updateAtributosEstruturaLente(atl1, 1);
        System.out.println(at.selectAtributosEstruturaLente(1).getDescricao());
//        at.deleteAtributosEstruturaLente(1);

        pc.insertPacientes(pacientes);
        System.out.println(pc.selectAllPacientes());
        pc.updatePacientes(pacientes1, 1);
        System.out.println(pc.selectPacientes(1).getNome());
//        pc.deletePacientes(1);

        esp.insertEspecialidadesMedicas(especialidadesMedicas);
        System.out.println(esp.selectAllEspecialidadesMedicas());
        esp.updateEspecialidadesMedicas(especialidadesMedicas1, 1);
        System.out.println(esp.selectEspecialidadesMedicas(1));
//        esp.deleteEspecialidadesMedicas(1);

        cm.insertConsultasMedicas(consultasMedicas);
        System.out.println(cm.selectAllConsultasMedicas());
        cm.updateConsultasMedicas(consultasMedicas1, 1);
        System.out.println(cm.selectConsultasMedicas(1));
//        cm.deleteConsultasMedicas(1);

        ro.insertReceitasOculos(receitasOculos);
        System.out.println(ro.selectAllReceitasOculos());
        ro.updateReceitasOculos(receitasOculos1, 1);
        System.out.println(ro.selectReceitasOculos(1));
//        ro.deleteReceitasOculos(1);

        ol.insertObservacoesLaudos(observacoesLaudos);
        System.out.println(ol.selectAllObservacoesLaudos());
        ol.updateObservacoesLaudos(observacoesLaudos1, 1);
        System.out.println(ol.selectObservacoesLaudos(1));
//        ol.deleteObservacoesLaudos(1);

        el.insertEstruturasLentes(estruturasLentes);
        System.out.println(el.selectAllEstruturasLentes());
        el.updateEstruturasLentes(estruturasLentes1, 1);
        System.out.println(el.selectEstruturasLentes(1));
//        el.deleteEstruturasLentes(1);

        epl.insertEspecificacoesLente(especificacoesLente);
        System.out.println(epl.selectAllEspecificacoesLente());
        epl.updateEspecificacoesLente(especificacoesLente1, 1);
        System.out.println(epl.selectEspecificacoesLente(1));
//        epl.deleteEspecificacoesLente(1);
    }
}
