import { ICliente } from "../interfaces/ICliente";
import { IConta } from "../interfaces/IConta";

export class Cliente implements ICliente {
    id: String = "";
    nome: String = "";
    email: String = "";
    senha: String = "";
    cpf: String = "";
    contas: IConta[] = new Array<IConta>();
}