import withTranslation from "next-translate/withTranslation";
import React from "react";
import PublicLayout from "../layouts/PublicLayout";
import Head from "next/head";

class Error extends React.Component {
  render() {
    const { t } = this.props.i18n;
    const { errorCode } = this.props;

    return (
      <PublicLayout>
        <Head>
          <title>{t(`common:${errorCode}.title`)}</title>
        </Head>
        <p>{t(`common:${errorCode}.message`)}</p>
      </PublicLayout>
    );
  }
}

Error.getInitialProps = ({ response, error }) => {
  let errorCode;
  if (response && error) {
    errorCode = error.statusCode;
  } else {
    errorCode = 404;
  }
  return { errorCode };
};

export default withTranslation(Error);
