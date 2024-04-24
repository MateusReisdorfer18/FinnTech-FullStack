import { IConta } from "./IConta";

export interface ICliente {
    id: String,
    nome: String,
    email: String,
    senha: String,
    cpf: String,
    contas: IConta[]
}