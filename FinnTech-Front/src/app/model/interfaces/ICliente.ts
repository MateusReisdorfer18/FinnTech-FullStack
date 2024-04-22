import { IConta } from "./IConta";

export interface ICliente {
    id: String,
    nome: String,
    email: String,
    cpf: String,
    contas: IConta[]
}