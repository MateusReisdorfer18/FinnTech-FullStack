import { IConta } from "./IConta";
import { ITipoPagamento } from "./ITipoPagamento";

export interface IPagamento {
    id: String,
    tipoPagamento: ITipoPagamento,
    remetente: IConta,
    destinatario: IConta
    valor: Number,
    dataCricao: Date
}