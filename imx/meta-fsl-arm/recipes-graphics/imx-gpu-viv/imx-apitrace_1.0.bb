# Copyright (C) 2014 Freescale Semiconductor

DESCRIPTION = "Set of tools to trace OpenGL OpenGL ES,Direct3D and DirectDrawAPIs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://usr/share/doc/apitrace/LICENSE.txt;md5=aeb969185a143c3c25130bc2c3ef9a50"
DEPENDS = "imx-gpu-viv"

inherit fsl-eula-unpack

SRC_URI = "${FSL_MIRROR}/imx-gpu-viv-5.0.11.p4.01-hfp.bin;fsl-eula=true"
SRC_URI[md5sum] = "b8573d742e2d8c5c0af40cf429a08630"
SRC_URI[sha256sum] = "faa330604b5856cc42f81c73dcd38a6867c592c87b45062f0ea09e7645e06d2e"

S = "${WORKDIR}/imx-gpu-viv-5.0.11.p4.01-hfp/apitrace"

do_install () {
    install -d ${D}${libdir}
    install -d ${D}${bindir}

    cp -axr ${S}/usr/lib/* ${D}${libdir}
    cp -axr ${S}/usr/bin/* ${D}${bindir}
}

FILES_${PN} = "${bindir} ${libdir}"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"
COMPATIBLE_MACHINE = "(mx6)"
