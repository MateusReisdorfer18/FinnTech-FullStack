import { IBanco } from "./IBanco"
import { ICliente } from "./ICliente"
import { IPagamento } from "./IPagamento"
import { ITipoConta } from "./ITipoConta"

export interface IConta {
    id: String,
    numero: Number,
    cliente: ICliente,
    tipoConta: ITipoConta,
    saldo: Number,
    limite: Number,
    banco: IBanco,
    extrato: IPagamento[]
}