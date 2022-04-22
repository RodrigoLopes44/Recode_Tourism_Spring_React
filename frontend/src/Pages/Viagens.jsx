import rj1 from '../Assets/Catalogo/RJ/paquetá-pousada-rj.svg';
import rj2 from '../Assets/Catalogo/RJ/ilha-grande-pousada.svg';
import sp1 from '../Assets/Catalogo/SP/pousada-caraguatatuba-SP.svg';
import sp2 from '../Assets/Catalogo/SP/pousada-higienopolis-SP.svg';
import sp3 from '../Assets/Catalogo/SP/pousada-vila-olimpia-SP.svg';
import ba from '../Assets/Catalogo/BA/pousada-ilheus-BA.svg';
import mg from '../Assets/Catalogo/MG/pousada-pocos-de-caldas-MG.svg';

export default function Viagens() {

    function exibir_categoria(cat) {
        const elementos = document.getElementsByClassName('trip');

        for (let i=0; i<elementos.length; i++) {            
            if (cat === elementos[i].id) {
                elementos[i].style = "display: block";
            }
            else {
                elementos[i].style = "display: none";
            }            
        }
    }

    let exibir_todos = () => {
        let elementos = document.getElementsByClassName('trip');        
    
        for (let i=0; i<elementos.length; i++) {
         elementos[i].style = "display: block";
        }
    }

    return (
        <>
            <div class="jumbotron text-center">
                <h2 class="display-4">
                    Somente aqui na Recode Pro Viagens você encontra o melhor destino que um
                    programador pode querer visitar!
                </h2>
                <br />
                <hr />
            </div>

            <section className="main d-flex">      
                <aside>
                    <div className="menu-lateral">
                        <ul className="list-group">
                            <li
                                className="list-group-item d-flex justify-content-between align-items-center"
                                onClick={exibir_todos()}>
                                Exibir todas as viagens
                                <span className="badge badge-primary badge-pill">7</span>
                            </li>
                            
                            <li
                                className="list-group-item d-flex justify-content-between align-items-center"
                                onClick={exibir_categoria('trip-rj')}>
                                Rio de Janeiro
                                <span className="badge badge-primary badge-pill">2</span>
                            </li>
                            
                            <li
                                className="list-group-item d-flex justify-content-between align-items-center"
                                onClick={exibir_categoria('trip-sp')}>
                                São Paulo
                                <span className="badge badge-primary badge-pill">3</span>
                            </li>
                            
                            <li
                                className="list-group-item d-flex justify-content-between align-items-center"
                                onClick={exibir_categoria('trip-mg')}>
                                Minas Gerais
                                <span className="badge badge-primary badge-pill">1</span>
                            </li>
                            
                            <li
                                className="list-group-item d-flex justify-content-between align-items-center"
                                onClick={exibir_categoria('trip-ba')}>
                                Bahia
                                <span className="badge badge-primary badge-pill">1</span>
                            </li>
                        </ul>
                    </div>
                </aside>

                <div
                    className="trip-options container-fluid d-flex flex-wrap">
                        <div className="row">
                            <div className="col-sm-6 col-lg-5 col-xl-3 mb-3">
                                <div
                                    className="trip card align-items-center"
                                    id="trip-rj"                   
                                    >
                                    <img
                                        className="card-img-top p-2"
                                        src={rj1}
                                        alt="Paquetá, Rio de Janeiro"
                                    />

                                    <div className="card-body">
                                        <p className="card-text">
                                        Paquetá - RJ <br />Preços a partir de R$ 500
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <div className="col-sm-6 col-lg-5 col-xl-3 mb-3">
                                <div
                                    className="trip card align-items-center"
                                    id="trip-rj">
                                    <img
                                        className="card-img-top p-2"
                                        src={rj2}
                                        alt="Ilha Grande Rio de Janeiro"
                                    />
                                    
                                    <div className="card-body">
                                        <p className="card-text">
                                        Ilha Grande - RJ <br />Preços a partir de R$ 300
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className="row">
                            <div className="col-sm-6 col-lg-5 col-xl-3 mb-3">
                                <div
                                    className="trip card align-items-center"
                                    id="trip-sp">
                                    <img
                                        className="card-img-top p-2"
                                        src={sp1}
                                        alt="Caraguatatuba São Paulo"
                                    />

                                    <div className="card-body">
                                        <p className="card-text">
                                        Caraguatatuba - SP <br />Preços a partir de R$ 200
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <div className="col-sm-6 col-lg-5 col-xl-3 mb-3">
                                <div
                                    className="trip card align-items-center"
                                    id="trip-sp">
                                    <img
                                        className="card-img-top p-2"
                                        src={sp2}
                                        alt="Higienópolis São Paulo"
                                    />
                                    
                                    <div className="card-body">
                                        <p className="card-text">
                                            Higienópolis - SP <br />Preços a partir de R$ 800
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <div className="col-sm-6 col-lg-5 col-xl-3 mb-3">
                                <div
                                    className="trip card align-items-center"
                                    id="trip-sp"
                                    
                                    >
                                    <img
                                        className="card-img-top p-2"
                                        src={sp3}
                                        alt="Vila Olímpia São Paulo"
                                    />
                                    <div className="card-body">
                                        <p className="card-text">
                                        Vila Olímpia - SP <br />Preços a partir de R$ 500
                                        </p>
                                    </div>
                                </div>
                            </div>

                        </div>
                            <div className="row">
                                <div className="col-sm-6 mb-3">
                                        <div
                                            className="trip card align-items-center"
                                            id="trip-ba">
                                            <img
                                                className="card-img-top p-2"
                                                src={ba}
                                                alt="Ilhéus Bahia"
                                            />
                                            <div className="card-body">
                                                <p className="card-text">
                                                Ilhéus - BA <br />Preços a partir de R$ 250
                                                </p>
                                            </div>
                                    </div>
                                </div>
                            </div>

                            <div className="row">
                                <div className="col-sm-6 mb-3">
                                    <div
                                    className="trip card align-items-center"
                                    id="trip-mg"
                                    
                                    >
                                    <img
                                        className="card-img-top p-2"
                                        src={mg}
                                        alt="Poços de Caldas Minas Gerais"
                                    />
                                    <div className="card-body">
                                        <p className="card-text">
                                        Poços de Caldas - MG <br />Preços a partir de R$ 500
                                        </p>
                                </div>
                            </div>
                        </div>                                    
                    </div>
                </div>
            </section>
        </>
    )
}