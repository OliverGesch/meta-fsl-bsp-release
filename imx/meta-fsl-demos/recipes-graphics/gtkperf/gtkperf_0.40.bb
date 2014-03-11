SUMMARY = "GTK Performance tool"
SECTION = "libs"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "http://prdownloads.sourceforge.net/gtkperf/${PN}_${PV}.tar.gz \
           file://Makevars"

SRC_URI[md5sum] = "4331dde4bb83865e15482885fcb0cc53"
SRC_URI[sha256sum] = "9704344e732038eecbd007dd996a56293a6b027b5b76f3f036273a3fae1ab27b"

S = "${WORKDIR}/${PN}"

inherit autotools binconfig pkgconfig gettext

do_configure_prepend () {
    rm -f ${S}/m4/init.m4
    cp -f ${WORKDIR}/Makevars ${S}/po/
}

do_install_append () {
    rm -rf ${D}/usr/doc
}

FILES_${PN} += "${datadir}/duck.png"
